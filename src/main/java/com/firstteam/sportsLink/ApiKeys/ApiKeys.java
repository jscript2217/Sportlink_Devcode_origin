package com.firstteam.sportsLink.ApiKeys;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

public class ApiKeys {

    public static JsonNode getSecret() {
        String secretName = "Api_Keys";
        Region region = Region.of("ap-northeast-2");

        // Create a Secrets Manager client
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(region)
                .build();

        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse getSecretValueResponse;

        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            // For a list of exceptions thrown, see
            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
            throw new RuntimeException("Failed to retrieve secret from AWS Secrets Manager", e);
        }

        String secretString = getSecretValueResponse.secretString();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(secretString);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse secret JSON", e);
        }
    }

    public static String getKakaoClientId() {
        return getSecret().get("kakao_client_id").asText();
    }

    public static String getKakaoRedirectUri() {
        return getSecret().get("kakao_redirect_uri").asText();
    }

    public static String getNaverClientId() {
        return getSecret().get("naver_client_id").asText();
    }

    public static String getNaverClientSecret() {
        return getSecret().get("naver_client_secret").asText();
    }
}
