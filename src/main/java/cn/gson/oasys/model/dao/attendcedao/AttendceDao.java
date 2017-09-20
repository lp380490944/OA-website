package cn.gson.oasys.model.dao.attendcedao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cn.gson.oasys.model.entity.attendce.Attends;
import cn.gson.oasys.model.entity.note.Attachment;
import cn.gson.oasys.model.entity.note.Note;
import cn.gson.oasys.model.entity.user.User;

@Repository
public interface AttendceDao  extends PagingAndSortingRepository<Attends, Long>{

  List<Attends> findByUser(User user);
  
  @Query("SELECT count(*) from Attends a where DATE_FORMAT(a.attendsTime,'%Y-%m') like %?1% and a.statusId=?2 and a.user.userId=?3")
  Integer countnum(String month,long statusId,long userid);
  
  @Query("FROM Attends a where a.attendsTime>?1 and a.attendsTime<?2")
  List<Attends> findoneweek(Date start,Date end);
} 
