package edu.global.sgs.www.college.dao;

import edu.global.sgs.www.entity.Section;
import edu.global.sgs.www.entity.custom.SectionCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SectionDao {
    //TODO 狗血命名！！
    List<SectionCustom> findAllCustom();

    void delete(int sectionId);

    void add(Section section);

    List<Section> findSelectedSection(@Param("staffId") String staffId, @Param("year") String year);

    int getSecId(String item, String s);

    List<Section> findAll();
}
