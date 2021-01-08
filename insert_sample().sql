DELIMITER $$
drop procedure insert_sample;
create procedure insert_sample()
begin
     declare len double;
     declare wid double;
     declare hei double;
     declare wei double;
     declare plus double;
     declare minus double;
     declare num int;
     set num=1000;
     set len=20;
     set wid=15;
     set hei=17;
     set wei=32;
     while num>=1 do
          set plus=rand();
          set minus=rand();
          if(plus>minus) then
			insert into sample3 (length,width,height,weight) values (len+rand(),wid+rand(),hei+rand(),wei+rand());
          end if;
          if(plus<minus) then
			insert into sample3 (length,width,height,weight) values (len-rand(),wid-rand(),hei-rand(),wei-rand());
          end if;
          set num=num-1;
	end while;
end $$
call insert_sample();
		
     