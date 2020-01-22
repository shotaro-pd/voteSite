SELECT happyo_sha_no,user_name,COUNT(*) as tohyosu,nyusha_nensu
FROM vote_result v
INNER JOIN table_user t
ON v.happyo_sha_no = t.user_id
GROUP BY (happyo_sha_no)
ORDER BY tohyosu DESC,happyo_sha_no;