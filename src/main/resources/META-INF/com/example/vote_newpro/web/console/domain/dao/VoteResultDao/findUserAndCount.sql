SELECT user_id,user_name,COUNT(uiunnn.happyo_sha_no) as tohyosu,nyusha_nensu
FROM (SELECT *
FROM vote_result v
    RIGHT OUTER JOIN table_user t
ON v.happyo_sha_no = t.user_id) as uiunnn
WHERE uiunnn.nyusha_nensu IN (1,2)
GROUP BY (user_id)
ORDER BY tohyosu DESC,happyo_sha_no;