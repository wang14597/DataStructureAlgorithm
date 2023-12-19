package org.wl.JavaConcurrency;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/*
* 基于生产者-消费者模型实现文件搜索和索引标记
*/
public class _006_DiskCrawler {
    private static class FileCrawler implements Runnable {
        private final BlockingDeque<File> fileQueue;
        private final FileFilter fileFilter;
        private final File root;

        public FileCrawler(BlockingDeque<File> fileQueue, FileFilter fileFilter, File root) {
            this.fileQueue = fileQueue;
            this.fileFilter = fileFilter;
            this.root = root;
        }

        @Override
        public void run() {
            try {
                crawl(root);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void crawl(File root) throws InterruptedException {
            File[] entries = root.listFiles(fileFilter);
            if (entries != null) {
                for (File entry: entries) {
                    if (entry.isDirectory())
                        crawl(entry);
                    else if (!alreadyIndexed(entry))
                        fileQueue.put(entry);

                }
            }
        }

        private boolean alreadyIndexed(File entry) {
            return fileQueue.contains(entry);
        }
    }

    private static class Indexer implements Runnable {
        private final BlockingDeque<File> queue;

        private Indexer(BlockingDeque<File> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true)
                    indexFile(queue.take());
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        private void indexFile(File take) {
            System.out.println("add index");
        }
    }

    public static void startIndexinng(File[] roots) {
        BlockingDeque<File> queue = new LinkedBlockingDeque<>();
        FileFilter fileFilter = pathname -> true;
        for (File root: roots){
            new Thread(new FileCrawler(queue, fileFilter, root)).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Indexer(queue)).start();
        }
    }
}
