@set user = 1
@set status = ('Wanting to Read', 'Currently Reading');

select b.title, l.reading_status 
from "library" l 
join "books" b
on l.book_id = b.book_id 
where l.user_id = :user and reading_status in :status;