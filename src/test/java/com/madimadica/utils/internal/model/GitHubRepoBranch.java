package com.madimadica.utils.internal.model;

import java.util.Objects;

public class GitHubRepoBranch {
    private long orgId;
    private long repoId;
    private String name;

    public GitHubRepoBranch(long orgId, long repoId, String name) {
        this.orgId = orgId;
        this.repoId = repoId;
        this.name = name;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public long getRepoId() {
        return repoId;
    }

    public void setRepoId(long repoId) {
        this.repoId = repoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitHubRepoBranch that = (GitHubRepoBranch) o;
        return orgId == that.orgId && repoId == that.repoId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgId, repoId, name);
    }
}
