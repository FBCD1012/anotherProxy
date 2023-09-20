package Mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.FifoCache;
import pojo.annotation;
import pojo.annotationCreator;
import pojo.createdTime;


import java.util.Date;
import java.util.List;


//这里是对之前的xml配置操作的一些衍生理解，如何进行也是非常必要的
@CacheNamespace(readWrite = false,size = 512,flushInterval = 6000,eviction = FifoCache.class)
public interface AnnotationMapper {

    @Insert("insert into annotation values(#{anName},#{anNum},#{anIntroduction})")
    int insertAnnotation(@Param("anName")String anName
                        , @Param("anNum")Integer anNum
                        , @Param("anIntroduction")String anIntroduction);

    @Insert("insert into annotationcreater value(#{CreatorName},#{CreatorAge},#{anNum},#{CreatorId})")
    int insertAnnotationCreator(@Param("CreatorName")String CreatorName,
                                @Param("CreatorAge")Integer CreatorAge,
                                @Param("anNum")Integer anNum,
                                @Param("CreatorId")Integer CreatorId);

    @Insert("insert into creatededtime value(#{CreatorId},#{CreatTime})")
    int insertCreatedTime(@Param("CreatorId")Integer creatorId, @Param("CreatTime") Date time);


    @Select("SELECT * FROM annotation AS an INNER JOIN annotationcreater AS a\n" +
            "ON an.anNum=a.anNum where an.anNum=#{anNum}")
    annotation selectForm3();


    @Select("\n" +
            "SELECT * FROM creatededtime AS cr INNER JOIN annotationcreater AS a\n" +
            "ON cr.CreatorId=a.CreatorId where cr.CreatorId=#{creatorId}")
    createdTime selectForm2();

    @Results(
            {
                    @Result(column = "CreatorName", id = true, property = "CreatorName"),
                    @Result(column = "CreatorAge", property = "CreatorName"),
                    @Result(column = "anNum", property = "anNum"),
                    @Result(column = "CreatorId", property = "CreatorId"),
                    @Result(column = "anNum", many = @Many(select = "selectForm3"),property = "listAnnotation"),
                    @Result(column = "CreatorId",many = @Many(select = "selectForm2"),property = "createdTime")
            }
    )
    @Select("select * from annotationcreater where anNum=#{anNum}")
    List<annotationCreator> selectForm(Integer anNum);



    @Results(
            {
                    @Result(column = "CreatorName", id = true, property = "CreatorName"),
                    @Result(column = "CreatorAge", property = "CreatorName"),
                    @Result(column = "anNum", property = "anNum"),
                    @Result(column = "CreatorId", property = "CreatorId"),
                    @Result(column = "anNum", one = @One(select = "selectForm3"),property = "listAnnotation"),
                    @Result(column = "CreatorId",one = @One(select = "selectForm2"),property = "createdTime")
            }
    )
    @Select("select * from annotationcreater where anNum=#{anNum}")
    List<annotationCreator> selectForm4(Integer anNum);


    @ConstructorArgs(
            {
                    @Arg(column = "anIntroduction", javaType = String.class)
            }
    )
    @Select("select * from annotation where anNum=#{anNum}")
    List<annotation> selectForm5(Integer anNum);

    @Insert("insert into annotationcreater values(#{annotationCreator.CreatorName}" +
            ",#{annotationCreator.CreatorAge},#{annotationCreator.anNum},#{annotationCreator.CreatorId})")
    int insertIntoAnnotationcreater(@Param("annotationCreator") annotationCreator annotationCreator);


    @Options(flushCache = Options.FlushCachePolicy.TRUE )
    @ResultMap("annotation")
    @Select("select * from annotation where anNum=#{aNum}")
    annotation selectTransaction(Integer aNum);
}
