# jta
此项目并不是分库分表，而是分布式事务的JTA实现
项目使用springmvc spring mybatis mysql实现了分布式事务
连接两个DB，member连接db1（名字起为master，并不是集群意义上的master）member_info连接db2（slave), 数据在两个db上
如果成功则插入两条数据，失败则全部回滚。
#ref
Spring JTA多数据源事务管理详细教程 - CSDN博客
https://blog.csdn.net/zhanglu0223/article/details/77963639

# 原理
分布式事务是指事务的参与者、支持事务的服务器、资源管理器以及事务管理器分别位于分布系统的不同节点之上，在两个或多个网络计算机资源上访问并且更新数据，将两个或多个网络计算机的数据进行的多次操作作为一个整体进行处理。如不同银行账户之间的转账。

       对于在项目中接触到JTA，大部分的原因是因为在项目中需要操作多个数据库，同时，可以保证操作的原子性，保证对多个数据库的操作一致性。 