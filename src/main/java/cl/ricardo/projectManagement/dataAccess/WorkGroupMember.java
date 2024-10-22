package cl.ricardo.projectManagement.dataAccess;

import java.util.Objects;

public class WorkGroupMember {
    
    private Integer id = null;
    
    private Integer userId = null;
    
    private Integer workGroupId = null;
    
    private String joinedAt = null;
    
    public WorkGroupMember() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(Integer workGroupId) {
        this.workGroupId = workGroupId;
    }

    public String getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(String joinedAt) {
        this.joinedAt = joinedAt;
    }

    @Override
    public String toString() {
        return "WorkGroupMember{" + "id=" + id + ", userId=" + userId + ", workGroupId=" + workGroupId + ", joinedAt=" + joinedAt + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.userId);
        hash = 59 * hash + Objects.hashCode(this.workGroupId);
        hash = 59 * hash + Objects.hashCode(this.joinedAt);
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
        final WorkGroupMember other = (WorkGroupMember) obj;
        if (!Objects.equals(this.joinedAt, other.joinedAt)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return Objects.equals(this.workGroupId, other.workGroupId);
    }
    
}
