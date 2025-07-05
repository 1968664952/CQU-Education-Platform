package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Mapper.CourseKuMapper;
import cn.com.chinahitech.bjmarket.course.Mapper.VideoPlaybackHistoryMapper;
import cn.com.chinahitech.bjmarket.course.Service.CourseKuService;
import cn.com.chinahitech.bjmarket.course.Service.VideoPlaybackHistoryService;
import cn.com.chinahitech.bjmarket.course.entity.CourseKu;
import cn.com.chinahitech.bjmarket.course.entity.VideoPlaybackHistory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoPlaybackHistoryServiceImpl implements VideoPlaybackHistoryService {

    @Autowired
    private VideoPlaybackHistoryMapper videoPlaybackHistoryMapper;


    @Override
    public int saveOrUpdateHistory(String studentId, int chapterId, int position, int lastPosition) {
        QueryWrapper<VideoPlaybackHistory> wrapper=new QueryWrapper<VideoPlaybackHistory>();
        UpdateWrapper<VideoPlaybackHistory> wrapper1=new UpdateWrapper<>();
        wrapper.eq("student_id",studentId).eq("chapter_id",chapterId).eq("position",position);
        // 查询是否存在记录
        VideoPlaybackHistory exist = videoPlaybackHistoryMapper.selectOne(wrapper);
        if (exist != null) {
            // 存在则更新
            VideoPlaybackHistory update=new VideoPlaybackHistory();
            update.setLastPosition(lastPosition);

            wrapper1.eq("student_id",studentId).eq("chapter_id",chapterId).eq("position",position);

            return videoPlaybackHistoryMapper.update(update,wrapper1);

        } else {
            // 不存在则插入
            VideoPlaybackHistory insert=new VideoPlaybackHistory();
            insert.setStudentId(studentId);
            insert.setChapterId(chapterId);
            insert.setPosition(position);
            insert.setLastPosition(lastPosition);
            return videoPlaybackHistoryMapper.insert(insert);
        }
    }

    @Override
    public int getLastPosition(String studentId, int chapterId, int position) {
        QueryWrapper<VideoPlaybackHistory> wrapper=new QueryWrapper<VideoPlaybackHistory>();
        wrapper.eq("student_id",studentId).eq("chapter_id",chapterId).eq("position",position);

        VideoPlaybackHistory history =new VideoPlaybackHistory();
        history=videoPlaybackHistoryMapper.selectOne(wrapper);
        if (history==null){
            return -1;
        }
        return history.getLastPosition();
    }
}
