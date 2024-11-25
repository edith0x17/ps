-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.NAME
from ANIMAL_INS i
inner join ANIMAL_OUTS o 
where i.ANIMAL_ID = o.ANIMAL_ID
and
o.DATETIME - i.DATETIME < 0
order by i.DATETIME asc;