package com.madimadica.utils.internal.model;

import java.util.Objects;

public class GitHubRepo {
    private long repoId;
    private long orgId;
    private String name;

    public GitHubRepo(long repoId, long orgId, String name) {
        this.repoId = repoId;
        this.orgId = orgId;
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
        GitHubRepo that = (GitHubRepo) o;
        return orgId == that.orgId && repoId == that.repoId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgId, repoId, name);
    }
}
