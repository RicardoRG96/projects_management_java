package cl.ricardo.projectManagement.dataAccess;

import java.util.Objects;

public class ProjectMember {
    
    private Integer id = null;
    
    private Integer projectId = null;
    
    private Integer userId = null;
    
    private String role;
    
    private String joinedAt = null;
    
    public ProjectMember() {
        this.role = "";
    }

    public ProjectMember(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(String joinedAt) {
        this.joinedAt = joinedAt;
    }

    @Override
    public String toString() {
        return "ProjectMember{" + "id=" + id + ", projectId=" + projectId + ", userId=" + userId + ", role=" + role + ", joinedAt=" + joinedAt + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.projectId);
        hash = 23 * hash + Objects.hashCode(this.userId);
        hash = 23 * hash + Objects.hashCode(this.role);
        hash = 23 * hash + Objects.hashCode(this.joinedAt);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProjectMember other = (ProjectMember) obj;
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.joinedAt, other.joinedAt)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.projectId, other.projectId)) {
            return false;
        }
        return Objects.equals(this.userId, other.userId);
    }
    
}
