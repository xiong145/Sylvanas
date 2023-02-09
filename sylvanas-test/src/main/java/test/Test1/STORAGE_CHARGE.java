//package test.Test1;
//
//public class STORAGE_CHARGE {
//
//    一：
//(SELECT (case when SUBSTR(ar.ewb_no,1,1)='T' then SUBSTR(ar.ewb_no,1,13) else SUBSTR(ar.ewb_no,1,12) end) as ewb_no,ar.scan_time,ar.site_id  FROM
//    hs_opt_arrive ar    where ar.scan_time between timeBegin and timeEnd ) arrive
//查 hs_opt_arrive 条件  where ar.scan_time between timeBegin and timeEnd
//    将带T的——>
//            (select arrive.ewb_no,
//    arrive.scan_time,
//    arrive.site_id,
//    F_GET_arrive_time(arrive.ewb_no, arrive.site_id,t.dispatch_site_id,(case when s.first_center_site_id=s1.first_center_site_id then 1 else 0 end))   minTime,
//    row_number() over(partition by arrive.ewb_no, arrive.site_id order by arrive.scan_time desc) r
//    from   (SELECT (case when SUBSTR(ar.ewb_no,1,1)='T' then SUBSTR(ar.ewb_no,1,13) else SUBSTR(ar.ewb_no,1,12) end) as ewb_no,ar.scan_time,ar.site_id  FROM
//    hs_opt_arrive ar    where ar.scan_time between timeBegin and timeEnd ) arrive
//    inner join hs_opt_ewb t on t.ewb_no = arrive.ewb_no  and t.shipping_method =285
//    left join hs_basic_site s on t.send_site_id=s.site_id   left join hs_basic_site s1 on t.dispatch_site_id=s1.site_id
//    where s1.first_center_site_id=arrive.site_id) arr
//
//            hs_opt_ewb+arrive+hs_basic_site
//            F_GET_arrive_time————>
//    row_number()？
//    over(partition by arrive.ewb_no, arrive.site_id order by arrive.scan_time desc) r ？
//
//
//
//
//            (select ewb_no,
//                          --  case when    minTime is not null and  minTime >  scan_time then scan_time else minTime end scan_time ,
//    F_GET_storage_time(ewb_no,minTime,1) as  scan_time,
//    site_id
//    from (select arrive.ewb_no,
//          arrive.scan_time,
//          arrive.site_id,
//          F_GET_arrive_time(arrive.ewb_no, arrive.site_id,t.dispatch_site_id,(case when s.first_center_site_id=s1.first_center_site_id then 1 else 0 end))   minTime,
//    row_number() over(partition by arrive.ewb_no, arrive.site_id order by arrive.scan_time desc) r
//    from   (SELECT (case when SUBSTR(ar.ewb_no,1,1)='T' then SUBSTR(ar.ewb_no,1,13) else SUBSTR(ar.ewb_no,1,12) end) as ewb_no,ar.scan_time,ar.site_id  FROM
//    hs_opt_arrive ar    where ar.scan_time between timeBegin and timeEnd ) arrive
//    inner join hs_opt_ewb t on t.ewb_no = arrive.ewb_no  and t.shipping_method =285
//    left join hs_basic_site s on t.send_site_id=s.site_id   left join hs_basic_site s1 on t.dispatch_site_id=s1.site_id
//    where s1.first_center_site_id=arrive.site_id) arr
//    where r = 1)
//
//    F_GET_storage_time(ewb_no,minTime,1) as  scan_time,————>
//
//
//    select ewb_no, send_site_id, amount
//    from temp_arr arr
//    inner join hs_opt_ewb t
//    on t.ewb_no = arr.ewb_no
//    and t.pick_goods_mode_id =
//            (select d.dict_id
//    from hs_basic_dict d
//    where d.dict_name = '自提'
//    and d.rd_status = 1
//    and d.type_code = 'pick_goods_mode')
//    and t.shipping_method =
//            (select d.dict_id
//    from hs_basic_dict d
//    where d.dict_name = '中心自提'
//    and d.rd_status = 1
//    and d.type_code = 'self_method')
//    inner join hs_basic_site s
//    on s.site_id = t.dispatch_site_id
//    and s.first_center_site_id = arr.site_id
//    left join hs_opt_sign sgn
//    on sgn.ewb_no = t.ewb_no
//    and sgn.site_id = t.dispatch_site_id
//    where not exists (select 1
//            from hs_fin_input f_s
//            where f_s.charge_item_id = chargeItemId
//            and f_s.ewb_no = arr.ewb_no)
//    and exists
//            (select 1
//                    from hs_basic_site s_arr
//                    where s_arr.site_id = arr.site_id
//                    and s_arr.site_type_id in (143, 144))
//    and arr.scan_time is not null
//
//    v  where amount > 0
//    取金额dayu0
//
//
//            loop
//    --如果费用小于0,不用生成到费用表
//    if data.amount > 0 then
//      --查询资金路由,循环生成对应费用
//      for accounts in (select f_acc.account_id
//            from hs_fin_account f_acc
//            where f_acc.account_id in
//            (SELECT ACCOUNT_ID
//            FROM HS_FIN_ACCOUNT
//            start with data_id = data.send_site_id
//            AND ACCOUNT_STATUS = 1
//            connect by NOCYCLE
//            PRIOR center_id = data_id
//            and data_id != 1617
//            AND ACCOUNT_STATUS = 1)
//    and f_acc.account_type_id = 10) loop
//        --费用生成,验证重复
//    merge into HS_FIN_INPUT f_ip
//    using (select count(1) as countFin
//    from hs_fin_input f_iu
//    where f_iu.account_id = accounts.account_id
//    and f_iu.charge_item_id = chargeItemId
//    and f_iu.ewb_no = data.ewb_no) f_us
//    on (f_us.countFin > 0)
//    when not matched then
//    insert
//            (ACCOUNT_INPUT_ID,
//             ACCOUNT_ID,
//             AMOUNT,
//             TRANS_TYPE,
//             CHARGE_ITEM_ID,
//             EWB_NO,
//             BL_AUDIT,
//             VALID_FLAG,
//             REMARK,
//             SYS_REMARK,
//             CREATED_BY,
//             CREATED_TIME,
//             FINANCE_FLAG)
//    VALUES
//            (seq_fin_input.nextval,
//             accounts.account_id,
//             data.amount,
//             1,
//             chargeItemId,
//             data.ewb_no,
//             0,
//                     1,
//                     '',
//                     '仓储费',
//                     25,
//             sysdate,
//             0);
//    commit;
//    end loop;
//    end if;
//    end loop;
// if data.amount > 0 then
//
//       --查询资金路由,循环生成对应费用
//      for accounts in (select f_acc.account_id
//            from hs_fin_account f_acc
//            where f_acc.account_id in
//            (SELECT ACCOUNT_ID
//            FROM HS_FIN_ACCOUNT
//            start with data_id = data.send_site_id
//            AND ACCOUNT_STATUS = 1
//            connect by NOCYCLE
//            PRIOR center_id = data_id
//            and data_id != 1617
//            AND ACCOUNT_STATUS = 1)
//    and f_acc.account_type_id = 10) loop  ????
//
//            --费用生成,验证重复
//    merge into HS_FIN_INPUT f_ip
//    using (select count(1) as countFin
//    from hs_fin_input f_iu
//    where f_iu.account_id = accounts.account_id
//    and f_iu.charge_item_id = chargeItemId
//    and f_iu.ewb_no = data.ewb_no) f_us
//    on (f_us.countFin > 0)
//    when not matched then
//    insert
//            (ACCOUNT_INPUT_ID,
//             ACCOUNT_ID,
//             AMOUNT,
//             TRANS_TYPE,
//             CHARGE_ITEM_ID,
//             EWB_NO,
//             BL_AUDIT,
//             VALID_FLAG,
//             REMARK,
//             SYS_REMARK,
//             CREATED_BY,
//             CREATED_TIME,
//             FINANCE_FLAG)
//    VALUES
//            (seq_fin_input.nextval,
//             accounts.account_id,
//             data.amount,
//             1,
//             chargeItemId,
//             data.ewb_no,
//             0,
//                     1,
//                     '',
//                     '仓储费',
//                     25,
//             sysdate,
//             0);
//    commit;
//    end loop;
//    end if;
//
//}
