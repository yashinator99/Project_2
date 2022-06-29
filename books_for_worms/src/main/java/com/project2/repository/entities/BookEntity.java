package com.project2.repository.entities;

import java.sql.Date;

public class BookEntity {
    private int book_id;
    private String title;
    private String author;
    private String genre;
    private Date year;
    private boolean fiction;
    private String description;

    public BookEntity(String title, String author, String genre, Date year, boolean fiction, String description) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.fiction = fiction;
        this.description = description;
    }

    public BookEntity(int book_id, String title, String author, String genre, Date year, boolean fiction, String description) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.fiction = fiction;
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + book_id;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + (fiction ? 1231 : 1237);
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BookEntity other = (BookEntity) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (book_id != other.book_id)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (fiction != other.fiction)
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public boolean isFiction() {
        return fiction;
    }

    public void setFiction(boolean fiction) {
        this.fiction = fiction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookEntity [author=" + author + ", book_id=" + book_id + ", description=" + description + ", fiction="
                + fiction + ", genre=" + genre + ", title=" + title + ", year=" + year + "]";
    }

}