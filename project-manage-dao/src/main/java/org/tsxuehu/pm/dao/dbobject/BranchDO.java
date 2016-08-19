package org.tsxuehu.pm.dao.dbobject;

public class BranchDO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branch.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branch.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branch.scmBranchId
     *
     * @mbggenerated
     */
    private String scmbranchid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branch.repositoryLocation
     *
     * @mbggenerated
     */
    private String repositorylocation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branch.applicationId
     *
     * @mbggenerated
     */
    private Long applicationid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branch.projectId
     *
     * @mbggenerated
     */
    private Long projectid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branch.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branch.extra
     *
     * @mbggenerated
     */
    private String extra;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branch.deployServer
     *
     * @mbggenerated
     */
    private String deployserver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branch.checkoutPoint
     *
     * @mbggenerated
     */
    private String checkoutpoint;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branch.creator
     *
     * @mbggenerated
     */
    private String creator;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branch.id
     *
     * @return the value of branch.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branch.id
     *
     * @param id the value for branch.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branch.name
     *
     * @return the value of branch.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branch.name
     *
     * @param name the value for branch.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branch.scmBranchId
     *
     * @return the value of branch.scmBranchId
     *
     * @mbggenerated
     */
    public String getScmbranchid() {
        return scmbranchid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branch.scmBranchId
     *
     * @param scmbranchid the value for branch.scmBranchId
     *
     * @mbggenerated
     */
    public void setScmbranchid(String scmbranchid) {
        this.scmbranchid = scmbranchid == null ? null : scmbranchid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branch.repositoryLocation
     *
     * @return the value of branch.repositoryLocation
     *
     * @mbggenerated
     */
    public String getRepositorylocation() {
        return repositorylocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branch.repositoryLocation
     *
     * @param repositorylocation the value for branch.repositoryLocation
     *
     * @mbggenerated
     */
    public void setRepositorylocation(String repositorylocation) {
        this.repositorylocation = repositorylocation == null ? null : repositorylocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branch.applicationId
     *
     * @return the value of branch.applicationId
     *
     * @mbggenerated
     */
    public Long getApplicationid() {
        return applicationid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branch.applicationId
     *
     * @param applicationid the value for branch.applicationId
     *
     * @mbggenerated
     */
    public void setApplicationid(Long applicationid) {
        this.applicationid = applicationid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branch.projectId
     *
     * @return the value of branch.projectId
     *
     * @mbggenerated
     */
    public Long getProjectid() {
        return projectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branch.projectId
     *
     * @param projectid the value for branch.projectId
     *
     * @mbggenerated
     */
    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branch.description
     *
     * @return the value of branch.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branch.description
     *
     * @param description the value for branch.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branch.extra
     *
     * @return the value of branch.extra
     *
     * @mbggenerated
     */
    public String getExtra() {
        return extra;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branch.extra
     *
     * @param extra the value for branch.extra
     *
     * @mbggenerated
     */
    public void setExtra(String extra) {
        this.extra = extra == null ? null : extra.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branch.deployServer
     *
     * @return the value of branch.deployServer
     *
     * @mbggenerated
     */
    public String getDeployserver() {
        return deployserver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branch.deployServer
     *
     * @param deployserver the value for branch.deployServer
     *
     * @mbggenerated
     */
    public void setDeployserver(String deployserver) {
        this.deployserver = deployserver == null ? null : deployserver.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branch.checkoutPoint
     *
     * @return the value of branch.checkoutPoint
     *
     * @mbggenerated
     */
    public String getCheckoutpoint() {
        return checkoutpoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branch.checkoutPoint
     *
     * @param checkoutpoint the value for branch.checkoutPoint
     *
     * @mbggenerated
     */
    public void setCheckoutpoint(String checkoutpoint) {
        this.checkoutpoint = checkoutpoint == null ? null : checkoutpoint.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branch.creator
     *
     * @return the value of branch.creator
     *
     * @mbggenerated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branch.creator
     *
     * @param creator the value for branch.creator
     *
     * @mbggenerated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }
}