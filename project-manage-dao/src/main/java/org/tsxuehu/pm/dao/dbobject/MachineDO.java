package org.tsxuehu.pm.dao.dbobject;

public class MachineDO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column machine.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column machine.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column machine.location
     *
     * @mbggenerated
     */
    private String location;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column machine.port
     *
     * @mbggenerated
     */
    private String port;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column machine.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column machine.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column machine.id
     *
     * @return the value of machine.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column machine.id
     *
     * @param id the value for machine.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column machine.name
     *
     * @return the value of machine.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column machine.name
     *
     * @param name the value for machine.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column machine.location
     *
     * @return the value of machine.location
     *
     * @mbggenerated
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column machine.location
     *
     * @param location the value for machine.location
     *
     * @mbggenerated
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column machine.port
     *
     * @return the value of machine.port
     *
     * @mbggenerated
     */
    public String getPort() {
        return port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column machine.port
     *
     * @param port the value for machine.port
     *
     * @mbggenerated
     */
    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column machine.username
     *
     * @return the value of machine.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column machine.username
     *
     * @param username the value for machine.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column machine.password
     *
     * @return the value of machine.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column machine.password
     *
     * @param password the value for machine.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}