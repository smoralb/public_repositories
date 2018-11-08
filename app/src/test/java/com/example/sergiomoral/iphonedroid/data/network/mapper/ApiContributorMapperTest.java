package com.example.sergiomoral.iphonedroid.data.network.mapper;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiContributor;
import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApiContributorMapperTest {

    @Test
    public void shouldMapContributor() {
        Gson gson = new Gson();
        String jsonResponse = getJsonResponse();

        ApiContributor apiContributor = gson.fromJson(jsonResponse, ApiContributor.class);
        Contributor contributor = getContributor(apiContributor);

        assertNotNull(apiContributor);
        assertNotNull(contributor);
        assertEquals(apiContributor.getUserName(), contributor.getUserName());
        assertEquals(new Long(apiContributor.getContributions()), new Long(contributor.getContributions()));
        assertEquals(apiContributor.getProfilePicture(), contributor.getProfilePicture());
    }

    private Contributor getContributor(ApiContributor apiContributor) {
        return new Contributor.Builder()
                .contributions(apiContributor.getContributions())
                .profilePicture(apiContributor.getProfilePicture())
                .userName(apiContributor.getUserName())
                .build();
    }


    private String getJsonResponse() {
        return "{\n" +
                "        \"login\": \"Spaceghost\",\n" +
                "        \"id\": 251370,\n" +
                "        \"node_id\": \"MDQ6VXNlcjI1MTM3MA==\",\n" +
                "        \"avatar_url\": \"https://avatars2.githubusercontent.com/u/251370?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/Spaceghost\",\n" +
                "        \"html_url\": \"https://github.com/Spaceghost\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/Spaceghost/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/Spaceghost/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/Spaceghost/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/Spaceghost/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/Spaceghost/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/Spaceghost/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/Spaceghost/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/Spaceghost/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/Spaceghost/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false,\n" +
                "        \"contributions\": 1\n" +
                "  }\n";
    }
}
