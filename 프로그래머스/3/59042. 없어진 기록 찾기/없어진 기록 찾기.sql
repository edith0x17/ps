select o.ANIMAL_ID, o.NAME
from ANIMAL_OUTS o 
left outer join ANIMAL_INS i ON o.ANIMAL_ID = i.ANIMAL_ID
where i.ANIMAL_ID is null
order by o.ANIMAL_ID asc; 