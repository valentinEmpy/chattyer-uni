package chattyer.web.api;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import chattyer.web.exception.handling.RestApiError;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

import chattyer.web.api.models.SpaceDto;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/spaces")
public class SpacesApi {

    @Autowired
    private SpacesApiService delegate;

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SpaceDto.class)))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpaceDto>>
           getSpaces(Principal principal, @RequestParam(value = "ids", required = false) List<UUID> ids,
                     @RequestParam(value = "names", required = false) List<String> names,
                     @RequestParam(value = "organization_ids", required = false) List<UUID> organizationIds) {
        return delegate.getSpaces(principal, ids, names, organizationIds);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SpaceDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @GetMapping(value = "/{spaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("@authChecker.hasSpaceScopeRole(principal, #spaceId, 'AUDITOR')")
    public ResponseEntity<SpaceDto> getSpace(@PathVariable("spaceId") UUID spaceId) {
        return delegate.getSpace(spaceId);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SpaceDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("@authChecker.hasOrganizationScopeRole(principal, #space.organization, 'DEVELOPER')")
    public ResponseEntity<SpaceDto> createSpace(Principal principal, @Valid @RequestBody SpaceDto space) {
        return delegate.createSpace(principal, space);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SpaceDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @PutMapping(value = "/{spaceId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("@authChecker.hasSpaceScopeRole(principal, #spaceId, 'DEVELOPER')")
    public ResponseEntity<SpaceDto> updateSpace(@PathVariable("spaceId") UUID spaceId, @Valid @RequestBody SpaceDto updatedSpace) {
        return delegate.updateSpace(spaceId, updatedSpace);
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "204", description = "No Content"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestApiError.class))) })
    @DeleteMapping("/{spaceId}")
    @PreAuthorize("@authChecker.hasSpaceScopeRole(principal, #spaceId, 'DEVELOPER')")
    public ResponseEntity<Void> deleteSpace(@PathVariable("spaceId") UUID spaceId) {
        return delegate.deleteSpace(spaceId);
    }
}
