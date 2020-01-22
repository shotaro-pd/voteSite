SELECT user_name,comment
FROM vote_result v
INNER JOIN table_user t
ON v.tohyo_sha_no = t.user_id
WHERE happyo_sha_no = /*happyoShaNo*/'2018000'
ORDER BY user_id;