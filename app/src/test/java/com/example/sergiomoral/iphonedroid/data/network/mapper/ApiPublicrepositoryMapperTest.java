package com.example.sergiomoral.iphonedroid.data.network.mapper;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiPublicRepositories;
import com.example.sergiomoral.iphonedroid.domain.entities.Owner;
import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.google.gson.Gson;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ApiPublicrepositoryMapperTest {

    Owner owner;
    PublicRepositories publicRepository;

    @Test
    public void shouldMapPublicRepositories() {

        Gson gson = new Gson();
        String jsonResponse = getJsonResponse();

        ApiPublicRepositories repository = gson.fromJson(jsonResponse, ApiPublicRepositories.class);
        publicRepository = getPublicrepositoryMapper(repository);
        owner = getOwner(repository);

        assertNotNull(repository);
        assertNotNull(publicRepository);
        assertNotNull(owner);
        assertEquals(repository.getContributors(), publicRepository.getContributors());
        assertEquals(repository.getOwner().getUserName(), owner.getUserName());
        assertEquals(repository.getOwner().getProfilePicture(), owner.getProfilePicture());
        assertEquals(repository.getIsPrivate(), publicRepository.getIsPrivate());
        assertEquals(repository.getIssues(), publicRepository.getIssues());
        assertEquals(repository.getPath(), publicRepository.getPath());
        assertEquals(repository.getProjectName(), publicRepository.getProjectName());
        assertEquals(repository.getProjectUrl(), publicRepository.getProjectUrl());

    }

    private Owner getOwner(ApiPublicRepositories repository) {

        return new Owner.Builder()
                .followers(repository.getOwner().getFollowers())
                .id(repository.getOwner().getIdOwner())
                .profilePicture(repository.getOwner().getProfilePicture())
                .repositories(repository.getOwner().getRespositories())
                .userName(repository.getOwner().getUserName())
                .userUrl(repository.getOwner().getUserUrl())
                .build();

    }

    private PublicRepositories getPublicrepositoryMapper(ApiPublicRepositories repository) {

        return new PublicRepositories.Builder()
                .branches(repository.getBranches())
                .contributors(repository.getContributors())
                .description(repository.getDescription())
                .forks(repository.getForks())
                .id(repository.getIdRepository())
                .isPrivate(repository.getIsPrivate())
                .issues(repository.getIssues())
                .owner(getOwner(repository))
                .path(repository.getPath())
                .projectName(repository.getProjectName())
                .projectUrl(repository.getProjectUrl())
                .build();
    }


    private String getJsonResponse() {
        return "  {\n" +
                "    \"id\": 1296269,\n" +
                "    \"node_id\": \"MDEwOlJlcG9zaXRvcnkxMjk2MjY5\",\n" +
                "    \"name\": \"Hello-World\",\n" +
                "    \"full_name\": \"octocat/Hello-World\",\n" +
                "    \"owner\": {\n" +
                "      \"login\": \"octocat\",\n" +
                "      \"id\": 1,\n" +
                "      \"node_id\": \"MDQ6VXNlcjE=\",\n" +
                "      \"avatar_url\": \"https://github.com/images/error/octocat_happy.gif\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/octocat\",\n" +
                "      \"html_url\": \"https://github.com/octocat\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/octocat/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/octocat/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/octocat/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/octocat/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/octocat/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/octocat/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/octocat/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/octocat/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/octocat/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"private\": false,\n" +
                "    \"html_url\": \"https://github.com/octocat/Hello-World\",\n" +
                "    \"description\": \"This your first repo!\",\n" +
                "    \"fork\": false,\n" +
                "    \"url\": \"https://api.github.com/repos/octocat/Hello-World\",\n" +
                "    \"archive_url\": \"http://api.github.com/repos/octocat/Hello-World/{archive_format}{/ref}\",\n" +
                "    \"assignees_url\": \"http://api.github.com/repos/octocat/Hello-World/assignees{/user}\",\n" +
                "    \"blobs_url\": \"http://api.github.com/repos/octocat/Hello-World/git/blobs{/sha}\",\n" +
                "    \"branches_url\": \"http://api.github.com/repos/octocat/Hello-World/branches{/branch}\",\n" +
                "    \"collaborators_url\": \"http://api.github.com/repos/octocat/Hello-World/collaborators{/collaborator}\",\n" +
                "    \"comments_url\": \"http://api.github.com/repos/octocat/Hello-World/comments{/number}\",\n" +
                "    \"commits_url\": \"http://api.github.com/repos/octocat/Hello-World/commits{/sha}\",\n" +
                "    \"compare_url\": \"http://api.github.com/repos/octocat/Hello-World/compare/{base}...{head}\",\n" +
                "    \"contents_url\": \"http://api.github.com/repos/octocat/Hello-World/contents/{+path}\",\n" +
                "    \"contributors_url\": \"http://api.github.com/repos/octocat/Hello-World/contributors\",\n" +
                "    \"deployments_url\": \"http://api.github.com/repos/octocat/Hello-World/deployments\",\n" +
                "    \"downloads_url\": \"http://api.github.com/repos/octocat/Hello-World/downloads\",\n" +
                "    \"events_url\": \"http://api.github.com/repos/octocat/Hello-World/events\",\n" +
                "    \"forks_url\": \"http://api.github.com/repos/octocat/Hello-World/forks\",\n" +
                "    \"git_commits_url\": \"http://api.github.com/repos/octocat/Hello-World/git/commits{/sha}\",\n" +
                "    \"git_refs_url\": \"http://api.github.com/repos/octocat/Hello-World/git/refs{/sha}\",\n" +
                "    \"git_tags_url\": \"http://api.github.com/repos/octocat/Hello-World/git/tags{/sha}\",\n" +
                "    \"git_url\": \"git:github.com/octocat/Hello-World.git\",\n" +
                "    \"issue_comment_url\": \"http://api.github.com/repos/octocat/Hello-World/issues/comments{/number}\",\n" +
                "    \"issue_events_url\": \"http://api.github.com/repos/octocat/Hello-World/issues/events{/number}\",\n" +
                "    \"issues_url\": \"http://api.github.com/repos/octocat/Hello-World/issues{/number}\",\n" +
                "    \"keys_url\": \"http://api.github.com/repos/octocat/Hello-World/keys{/key_id}\",\n" +
                "    \"labels_url\": \"http://api.github.com/repos/octocat/Hello-World/labels{/name}\",\n" +
                "    \"languages_url\": \"http://api.github.com/repos/octocat/Hello-World/languages\",\n" +
                "    \"merges_url\": \"http://api.github.com/repos/octocat/Hello-World/merges\",\n" +
                "    \"milestones_url\": \"http://api.github.com/repos/octocat/Hello-World/milestones{/number}\",\n" +
                "    \"notifications_url\": \"http://api.github.com/repos/octocat/Hello-World/notifications{?since,all,participating}\",\n" +
                "    \"pulls_url\": \"http://api.github.com/repos/octocat/Hello-World/pulls{/number}\",\n" +
                "    \"releases_url\": \"http://api.github.com/repos/octocat/Hello-World/releases{/id}\",\n" +
                "    \"ssh_url\": \"git@github.com:octocat/Hello-World.git\",\n" +
                "    \"stargazers_url\": \"http://api.github.com/repos/octocat/Hello-World/stargazers\",\n" +
                "    \"statuses_url\": \"http://api.github.com/repos/octocat/Hello-World/statuses/{sha}\",\n" +
                "    \"subscribers_url\": \"http://api.github.com/repos/octocat/Hello-World/subscribers\",\n" +
                "    \"subscription_url\": \"http://api.github.com/repos/octocat/Hello-World/subscription\",\n" +
                "    \"tags_url\": \"http://api.github.com/repos/octocat/Hello-World/tags\",\n" +
                "    \"teams_url\": \"http://api.github.com/repos/octocat/Hello-World/teams\",\n" +
                "    \"trees_url\": \"http://api.github.com/repos/octocat/Hello-World/git/trees{/sha}\"\n" +
                "  }\n";
    }

}
