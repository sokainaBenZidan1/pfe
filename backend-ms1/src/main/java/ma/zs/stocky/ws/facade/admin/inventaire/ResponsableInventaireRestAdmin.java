package  ma.zs.stocky.ws.facade.admin.inventaire;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.inventaire.ResponsableInventaire;
import ma.zs.stocky.dao.criteria.core.inventaire.ResponsableInventaireCriteria;
import ma.zs.stocky.service.facade.admin.inventaire.ResponsableInventaireAdminService;
import ma.zs.stocky.ws.converter.inventaire.ResponsableInventaireConverter;
import ma.zs.stocky.ws.dto.inventaire.ResponsableInventaireDto;
import ma.zs.stocky.zynerator.controller.AbstractController;
import ma.zs.stocky.zynerator.dto.AuditEntityDto;
import ma.zs.stocky.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.stocky.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.stocky.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/responsableInventaire/")
public class ResponsableInventaireRestAdmin  extends AbstractController<ResponsableInventaire, ResponsableInventaireDto, ResponsableInventaireCriteria, ResponsableInventaireAdminService, ResponsableInventaireConverter> {



    @Operation(summary = "upload one responsableInventaire")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple responsableInventaires")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all responsableInventaires")
    @GetMapping("")
    public ResponseEntity<List<ResponsableInventaireDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  responsableInventaire")
    @PostMapping("")
    public ResponseEntity<ResponsableInventaireDto> save(@RequestBody ResponsableInventaireDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  responsableInventaire")
    @PutMapping("")
    public ResponseEntity<ResponsableInventaireDto> update(@RequestBody ResponsableInventaireDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of responsableInventaire")
    @PostMapping("multiple")
    public ResponseEntity<List<ResponsableInventaireDto>> delete(@RequestBody List<ResponsableInventaireDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified responsableInventaire")
    @DeleteMapping("")
    public ResponseEntity<ResponsableInventaireDto> delete(@RequestBody ResponsableInventaireDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified responsableInventaire")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple responsableInventaires by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a responsableInventaire and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ResponsableInventaireDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds responsableInventaires by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ResponsableInventaireDto>> findByCriteria(@RequestBody ResponsableInventaireCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated responsableInventaires by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ResponsableInventaireCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports responsableInventaires by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ResponsableInventaireCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets responsableInventaire data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ResponsableInventaireCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ResponsableInventaireRestAdmin (ResponsableInventaireAdminService service, ResponsableInventaireConverter converter) {
        super(service, converter);
    }




}
