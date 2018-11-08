package com.example.sergiomoral.iphonedroid.data.network.mapper;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiFork;
import com.example.sergiomoral.iphonedroid.domain.entities.Fork;
import com.google.gson.Gson;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class ApiForkMapperTest {


    @Test
    public void shouldMapFork() {
        Gson gson = new Gson();
        String jsonResponse = getJsonResponse();

        ApiFork apiFork = gson.fromJson(jsonResponse, ApiFork.class);
        Fork fork = getFork(apiFork);

        assertNotNull(apiFork);
        assertNotNull(fork);
        assertEquals(new Long(apiFork.getIdFork()), new Long(fork.getId()));
        assertEquals(apiFork.getForkName(), fork.getName());
    }

    private Fork getFork(ApiFork apiFork) {

        return new Fork.Builder()
                .id(apiFork.getIdFork())
                .name(apiFork.getForkName())
                .build();
    }


    private String getJsonResponse() {
        return "    {\n" +
                "        \"id\": 156344644,\n" +
                "        \"node_id\": \"MDEwOlJlcG9zaXRvcnkxNTYzNDQ2NDQ=\",\n" +
                "        \"name\": \"Hello-World\",\n" +
                "        \"full_name\": \"sunaiyue/Hello-World\",\n" +
                "        \"private\": false,\n" +
                "        \"owner\": {\n" +
                "            \"login\": \"sunaiyue\",\n" +
                "            \"id\": 44402341,\n" +
                "            \"node_id\": \"MDQ6VXNlcjQ0NDAyMzQx\",\n" +
                "            \"avatar_url\": \"https://avatars1.githubusercontent.com/u/44402341?v=4\",\n" +
                "            \"gravatar_id\": \"\",\n" +
                "            \"url\": \"https://api.github.com/users/sunaiyue\",\n" +
                "            \"html_url\": \"https://github.com/sunaiyue\",\n" +
                "            \"followers_url\": \"https://api.github.com/users/sunaiyue/followers\",\n" +
                "            \"following_url\": \"https://api.github.com/users/sunaiyue/following{/other_user}\",\n" +
                "            \"gists_url\": \"https://api.github.com/users/sunaiyue/gists{/gist_id}\",\n" +
                "            \"starred_url\": \"https://api.github.com/users/sunaiyue/starred{/owner}{/repo}\",\n" +
                "            \"subscriptions_url\": \"https://api.github.com/users/sunaiyue/subscriptions\",\n" +
                "            \"organizations_url\": \"https://api.github.com/users/sunaiyue/orgs\",\n" +
                "            \"repos_url\": \"https://api.github.com/users/sunaiyue/repos\",\n" +
                "            \"events_url\": \"https://api.github.com/users/sunaiyue/events{/privacy}\",\n" +
                "            \"received_events_url\": \"https://api.github.com/users/sunaiyue/received_events\",\n" +
                "            \"type\": \"User\",\n" +
                "            \"site_admin\": false\n" +
                "        },\n" +
                "        \"html_url\": \"https://github.com/sunaiyue/Hello-World\",\n" +
                "        \"description\": \"My first repository on GitHub!\",\n" +
                "        \"fork\": true,\n" +
                "        \"url\": \"https://api.github.com/repos/sunaiyue/Hello-World\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/sunaiyue/Hello-World/deployments\",\n" +
                "        \"created_at\": \"2018-11-06T07:38:41Z\",\n" +
                "        \"updated_at\": \"2018-11-06T07:38:43Z\",\n" +
                "        \"pushed_at\": \"2018-10-31T12:23:19Z\",\n" +
                "        \"git_url\": \"git://github.com/sunaiyue/Hello-World.git\",\n" +
                "        \"ssh_url\": \"git@github.com:sunaiyue/Hello-World.git\",\n" +
                "        \"clone_url\": \"https://github.com/sunaiyue/Hello-World.git\",\n" +
                "        \"svn_url\": \"https://github.com/sunaiyue/Hello-World\",\n" +
                "        \"homepage\": \"\",\n" +
                "        \"size\": 1,\n" +
                "        \"stargazers_count\": 0,\n" +
                "        \"watchers_count\": 0,\n" +
                "        \"language\": null,\n" +
                "        \"has_issues\": false,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": true,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 0,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 0,\n" +
                "        \"license\": null,\n" +
                "        \"forks\": 0,\n" +
                "        \"open_issues\": 0,\n" +
                "        \"watchers\": 0,\n" +
                "        \"default_branch\": \"master\"\n" +
                "    }";
    }
}
