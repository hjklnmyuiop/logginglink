package com.example.devguo;

/**
 * @Author: dev_guo
 * @Date: 2023/2/20 16:39
 */
public class Pair<T> {
//asdfasfd
        private T first;
        private T last;
        public Pair(T first, T last) {
            this.first = first;
            this.last = last;
        }
        public T getFirst() {
            return first;
        }
        public T getLast() {
            return last;
        }
        public void setFirst(T first) {
            this.first = first;
        }
        public void setLast(T last) {
            this.last = last;
        }
    }