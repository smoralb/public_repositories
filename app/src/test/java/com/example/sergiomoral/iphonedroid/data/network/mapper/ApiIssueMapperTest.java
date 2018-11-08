package com.example.sergiomoral.iphonedroid.data.network.mapper;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiIssue;
import com.example.sergiomoral.iphonedroid.domain.entities.Issue;
import com.google.gson.Gson;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class ApiIssueMapperTest {


    @Test
    public void shouldMapIssue() {
        Gson gson = new Gson();
        String jsonResponse = getJsonResponse();

        ApiIssue apiIssue = gson.fromJson(jsonResponse, ApiIssue.class);
        Issue issue = getIssue(apiIssue);

        assertNotNull(apiIssue);
        assertNotNull(issue);
        assertEquals(new Long(apiIssue.getIssueNumber()), new Long(issue.getNumber()));
    }

    private Issue getIssue(ApiIssue apiIssue) {

        return new Issue.Builder()
                .number(apiIssue.getIssueNumber())
                .build();
    }


    private String getJsonResponse() {
        return "    {\n" +
                "        \"url\": \"https://api.github.com/repos/mojombo/grit/issues/256\",\n" +
                "        \"repository_url\": \"https://api.github.com/repos/mojombo/grit\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/mojombo/grit/issues/256/labels{/name}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/mojombo/grit/issues/256/comments\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/mojombo/grit/issues/256/events\",\n" +
                "        \"html_url\": \"https://github.com/mojombo/grit/issues/256\",\n" +
                "        \"id\": 371798309,\n" +
                "        \"node_id\": \"MDU6SXNzdWUzNzE3OTgzMDk=\",\n" +
                "        \"number\": 256,\n" +
                "        \"title\": \"test\",\n" +
                "        \"user\": {\n" +
                "            \"login\": \"builder12\",\n" +
                "            \"id\": 36386637,\n" +
                "            \"node_id\": \"MDQ6VXNlcjM2Mzg2NjM3\",\n" +
                "            \"avatar_url\": \"https://avatars3.githubusercontent.com/u/36386637?v=4\",\n" +
                "            \"gravatar_id\": \"\",\n" +
                "            \"url\": \"https://api.github.com/users/builder12\",\n" +
                "            \"html_url\": \"https://github.com/builder12\",\n" +
                "            \"followers_url\": \"https://api.github.com/users/builder12/followers\",\n" +
                "            \"following_url\": \"https://api.github.com/users/builder12/following{/other_user}\",\n" +
                "            \"gists_url\": \"https://api.github.com/users/builder12/gists{/gist_id}\",\n" +
                "            \"starred_url\": \"https://api.github.com/users/builder12/starred{/owner}{/repo}\",\n" +
                "            \"subscriptions_url\": \"https://api.github.com/users/builder12/subscriptions\",\n" +
                "            \"organizations_url\": \"https://api.github.com/users/builder12/orgs\",\n" +
                "            \"repos_url\": \"https://api.github.com/users/builder12/repos\",\n" +
                "            \"events_url\": \"https://api.github.com/users/builder12/events{/privacy}\",\n" +
                "            \"received_events_url\": \"https://api.github.com/users/builder12/received_events\",\n" +
                "            \"type\": \"User\",\n" +
                "            \"site_admin\": false\n" +
                "        },\n" +
                "        \"labels\": [],\n" +
                "        \"state\": \"open\",\n" +
                "        \"locked\": false,\n" +
                "        \"assignee\": null,\n" +
                "        \"assignees\": [],\n" +
                "        \"milestone\": null,\n" +
                "        \"comments\": 0,\n" +
                "        \"created_at\": \"2018-10-19T03:59:36Z\",\n" +
                "        \"updated_at\": \"2018-10-19T03:59:36Z\",\n" +
                "        \"closed_at\": null,\n" +
                "        \"author_association\": \"NONE\",\n" +
                "        \"body\": \"test\"\n" +
                "    }";
    }
}
