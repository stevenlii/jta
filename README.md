# jta
此项目并不是分库分表，而是分布式事务的JTA实现
连接两个DB，member连接db1（名字起为master，并不是集群意义上的master）member_info连接db2（slave), 数据在两个db上
如果成功则插入两条数据，失败则全部回滚。
