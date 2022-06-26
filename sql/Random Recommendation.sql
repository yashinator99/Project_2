select
	title,
	author,
	genre,
	"year",
	case
		when fiction
		then 'fiction'
		else 'non-fiction' end as "Fiction",
	description 
from public.books
order by random()
limit 1;