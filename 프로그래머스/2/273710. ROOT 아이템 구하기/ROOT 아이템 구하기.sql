SELECT IT.ITEM_ID, II.ITEM_NAME
FROM ITEM_TREE IT
JOIN ITEM_INFO II ON IT.ITEM_ID = II.ITEM_ID
WHERE IT.PARENT_ITEM_ID IS NULL;