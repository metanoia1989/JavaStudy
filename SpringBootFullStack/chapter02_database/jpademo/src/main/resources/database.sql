--- 创建数据库
CREATE DATABASE `jpa` DEFAULT CHARACTER SET utf8;

--- 插入数据
INSERT INTO `t_book` (`author`, `book_name`, `price`) VALUES
('罗贯中', '三国演义', 30),
('曹雪芹', '红楼梦', 35),
('吴承恩', '西游记', 29),
('施耐庵', '水浒传', 33),
('钱钟书', '宋诗选注', 18),
('鲁迅', '朝花夕拾', 22);