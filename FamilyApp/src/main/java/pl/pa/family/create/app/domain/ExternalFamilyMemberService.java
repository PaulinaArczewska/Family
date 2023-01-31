package pl.pa.family.create.app.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pa.family.create.app.error.InvalidFamilyDataException;

import pl.pa.family.create.app.model.FamilyDTO;
import pl.pa.family.create.app.model.FamilyMemberDTO;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import java.util.stream.Collectors;


@Service
public class ExternalFamilyMemberService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${family.member.host}")
    private String familyMemberHost;
    @Value("${family.member.port}")
    private String familyMemberPort;

    private final String createNewFamilyMemberApi = "familyMembers/";
    private final String searchNewFamilyMemberApi = "familyMembers/";

    boolean createNewFamilyMember(int familyId, FamilyDTO familyDTO) {

        ResponseEntity<Void> response = restTemplate.postForEntity(buildUrl() + createNewFamilyMemberApi + familyId, familyDTO.getFamilyMember(), Void.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new InvalidFamilyDataException("Unexpected error from family member service.");
        }
        return true;
    }

    Collection<FamilyMemberDTO> getFamilyMembers(int familyId) {

        ResponseEntity<FamilyMemberDTO[]> response = restTemplate.getForEntity(buildUrl() + searchNewFamilyMemberApi + familyId, FamilyMemberDTO[].class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new InvalidFamilyDataException("Unexpected error from family member service.");
        }
        if (response.getBody() != null) {
            return Arrays.stream(response.getBody()).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private String buildUrl() {
        return familyMemberHost + ":" + familyMemberPort + "/";
    }
}
