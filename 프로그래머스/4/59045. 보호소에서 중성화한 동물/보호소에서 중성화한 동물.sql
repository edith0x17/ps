select ao.ANIMAL_ID, ao.ANIMAL_TYPE, ao.NAME
from ANIMAL_OUTS ao
join ANIMAL_INS ai on ao.ANIMAL_ID = ai.ANIMAL_ID
where (ao.SEX_UPON_OUTCOME like '%Spayed%' || ao.SEX_UPON_OUTCOME like '%Neutered%')
    and ai.SEX_UPON_INTAKE like '%Intact%'
order by ao.ANIMAL_ID;