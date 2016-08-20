package org.tsxuehu.pm.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tsxuehu.pm.dao.dbobject.GroupBranchRelationDO;
import org.tsxuehu.pm.dao.dbobject.GroupBranchRelationDOExample;
import org.tsxuehu.pm.dao.dbobject.GroupBranchRelationDOKey;

public interface GroupBranchRelationDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_branch_relation
     *
     * @mbggenerated
     */
    int countByExample(GroupBranchRelationDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_branch_relation
     *
     * @mbggenerated
     */
    int deleteByExample(GroupBranchRelationDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_branch_relation
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(GroupBranchRelationDOKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_branch_relation
     *
     * @mbggenerated
     */
    int insert(GroupBranchRelationDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_branch_relation
     *
     * @mbggenerated
     */
    int insertSelective(GroupBranchRelationDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_branch_relation
     *
     * @mbggenerated
     */
    List<GroupBranchRelationDO> selectByExample(GroupBranchRelationDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_branch_relation
     *
     * @mbggenerated
     */
    GroupBranchRelationDO selectByPrimaryKey(GroupBranchRelationDOKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_branch_relation
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") GroupBranchRelationDO record, @Param("example") GroupBranchRelationDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_branch_relation
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") GroupBranchRelationDO record, @Param("example") GroupBranchRelationDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_branch_relation
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(GroupBranchRelationDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_branch_relation
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(GroupBranchRelationDO record);
}