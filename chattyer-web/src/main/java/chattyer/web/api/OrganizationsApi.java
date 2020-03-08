package chattyer.web.api;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chattyer.web.api.models.OrganizationDto;
import chattyer.web.exception.handling.RestApiError;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/organizations")
public class OrganizationsApi {

    @Autowired
    private OrganizationsApiService delegate;

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrganizationDto.class)))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrganizationDto>> getOrganizations(Principal principal,
                                                                  @RequestParam(value = "ids", required = false) List<UUID> ids,
                                                                  @RequestParam(value = "names", required = false) List<String> names) {
        return delegate.getOrganizations(principal, ids, names);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @GetMapping(value = "/{organizationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("@authChecker.hasOrganizationScopeRole(principal, #organizationId, 'AUDITOR')")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("organizationId") UUID organizationId) {
        return delegate.getOrganization(organizationId);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrganizationDto> createOrganization(Principal principal, @Valid @RequestBody OrganizationDto organization) {
        return delegate.createOrganization(principal, organization);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @PutMapping(value = "/{organizationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("@authChecker.hasOrganizationScopeRole(principal, #organizationId, 'DEVELOPER')")
    public ResponseEntity<OrganizationDto> updateOrganization(@PathVariable("organizationId") UUID organizationId,
                                                              @Valid @RequestBody OrganizationDto updatedOrganization) {
        return delegate.updateOrganization(organizationId, updatedOrganization);
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "204", description = "No Content"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @DeleteMapping("/{organizationId}")
    @PreAuthorize("@authChecker.hasOrganizationScopeRole(principal, #organizationId, 'MANAGER')")
    public ResponseEntity<Void> deleteOrganization(@PathVariable("organizationId") UUID organizationId) {
        return delegate.deleteOrganization(organizationId);
    }

}
