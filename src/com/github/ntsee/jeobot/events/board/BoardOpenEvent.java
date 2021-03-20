package com.github.ntsee.jeobot.events.board;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

import java.util.ArrayList;
import java.util.Collection;

public class BoardOpenEvent extends Event {

    private final int id;
    private final Collection<Post> posts;

    public BoardOpenEvent(EOReader reader) {
        this.id = reader.readChar();
        this.posts = new ArrayList<>();
        for (int i=0, n=reader.readChar(); i<n; i++) {
            int id = reader.readShort();
            reader.readBreakString();
            String author = reader.readBreakString();
            String subject = reader.readBreakString();
            this.posts.add(new Post(id, author, subject));
        }
    }

    public int getID() {
        return this.id;
    }

    public Collection<Post> getPosts() {
        return this.posts;
    }

    public static class Post {

        private final int id;
        private final String author;
        private final String subject;

        public Post(int id, String author, String subject) {
            this.id = id;
            this.author = author;
            this.subject = subject;
        }

        public int getID() {
            return this.id;
        }

        public String getAuthor() {
            return this.author;
        }

        public String getSubject() {
            return this.subject;
        }

        @Override
        public String toString() {
            return "Post{" +
                    "id=" + id +
                    ", author='" + author + '\'' +
                    ", subject='" + subject + '\'' +
                    '}';
        }
    }
}
