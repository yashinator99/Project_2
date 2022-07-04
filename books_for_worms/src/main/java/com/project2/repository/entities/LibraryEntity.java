package com.project2.repository.entities;

public class LibraryEntity {
    private int user_id;
    private int book_id;
    private String reading_status;

    public LibraryEntity(int user_id, int book_id) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.reading_status = "Wanting to Read";
    }

    public LibraryEntity(int user_id, int book_id, String reading_status) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.reading_status = reading_status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + book_id;
        result = prime * result + ((reading_status == null) ? 0 : reading_status.hashCode());
        result = prime * result + user_id;
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
        LibraryEntity other = (LibraryEntity) obj;
        if (book_id != other.book_id)
            return false;
        if (reading_status == null) {
            if (other.reading_status != null)
                return false;
        } else if (!reading_status.equals(other.reading_status))
            return false;
        if (user_id != other.user_id)
            return false;
        return true;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getReading_status() {
        return reading_status;
    }

    public void setReading_status(String reading_status) {
        this.reading_status = reading_status;
    }

    @Override
    public String toString() {
        return "LibraryEntity [book_id=" + book_id + ", reading_status=" + reading_status + ", user_id=" + user_id
                + "]";
    }
}
