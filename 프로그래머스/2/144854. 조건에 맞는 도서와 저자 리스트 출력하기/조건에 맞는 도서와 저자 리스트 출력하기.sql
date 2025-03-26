select bk.BOOK_ID, ar.AUTHOR_NAME, date_format(bk.published_date, '%Y-%m-%d') as PUBLISHED_DATE
from book bk
join author ar on bk.author_id = ar.author_id
where bk.category like '%경제%'
order by bk.published_date asc;