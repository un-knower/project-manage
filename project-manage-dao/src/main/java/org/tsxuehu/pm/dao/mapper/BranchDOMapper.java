package org.tsxuehu.pm.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tsxuehu.pm.dao.dbobject.BranchDO;
import org.tsxuehu.pm.dao.dbobject.BranchDOExample;

public interface BranchDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branch
     *
     * @mbggenerated
     */
    int countByExample(BranchDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branch
     *
     * @mbggenerated
     */
    int deleteByExample(BranchDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branch
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branch
     *
     * @mbggenerated
     */
    int insert(BranchDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branch
     *
     * @mbggenerated
     */
    int insertSelective(BranchDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branch
     *
     * @mbggenerated
     */
    List<BranchDO> selectByExample(BranchDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branch
     *
     * @mbggenerated
     */
    BranchDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branch
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") BranchDO record, @Param("example") BranchDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branch
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") BranchDO record, @Param("example") BranchDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branch
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BranchDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branch
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BranchDO record);
}