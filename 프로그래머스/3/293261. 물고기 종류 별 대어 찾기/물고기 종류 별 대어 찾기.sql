SELECT fi.id AS ID, fni.FISH_NAME, fi.length AS LENGTH
FROM FISH_INFO fi
JOIN FISH_NAME_INFO fni ON fi.FISH_TYPE = fni.FISH_TYPE
JOIN (
    SELECT FISH_TYPE, MAX(LENGTH) AS max_length
    FROM FISH_INFO
    GROUP BY FISH_TYPE
) AS sub
ON fi.FISH_TYPE = sub.FISH_TYPE AND fi.LENGTH = sub.max_length;