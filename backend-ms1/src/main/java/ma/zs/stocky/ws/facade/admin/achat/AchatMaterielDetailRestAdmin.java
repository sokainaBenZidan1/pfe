package  ma.zs.stocky.ws.facade.admin.achat;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.achat.AchatMaterielDetail;
import ma.zs.stocky.dao.criteria.core.achat.AchatMaterielDetailCriteria;
import ma.zs.stocky.service.facade.admin.achat.AchatMaterielDetailAdminService;
import ma.zs.stocky.ws.converter.achat.AchatMaterielDetailConverter;
import ma.zs.stocky.ws.dto.achat.AchatMaterielDetailDto;
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
@RequestMapping("/api/admin/achatMaterielDetail/")
public class AchatMaterielDetailRestAdmin  extends AbstractController<AchatMaterielDetail, AchatMaterielDetailDto, AchatMaterielDetailCriteria, AchatMaterielDetailAdminService, AchatMaterielDetailConverter> {



    @Operation(summary = "upload one achatMaterielDetail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple achatMaterielDetails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all achatMaterielDetails")
    @GetMapping("")
    public ResponseEntity<List<AchatMaterielDetailDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  achatMaterielDetail")
    @PostMapping("")
    public ResponseEntity<AchatMaterielDetailDto> save(@RequestBody AchatMaterielDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  achatMaterielDetail")
    @PutMapping("")
    public ResponseEntity<AchatMaterielDetailDto> update(@RequestBody AchatMaterielDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of achatMaterielDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<AchatMaterielDetailDto>> delete(@RequestBody List<AchatMaterielDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified achatMaterielDetail")
    @DeleteMapping("")
    public ResponseEntity<AchatMaterielDetailDto> delete(@RequestBody AchatMaterielDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified achatMaterielDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple achatMaterielDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<AchatMaterielDetailDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by achatMateriel id")
    @GetMapping("achatMateriel/id/{id}")
    public List<AchatMaterielDetailDto> findByAchatMaterielId(@PathVariable Long id){
        return findDtos(service.findByAchatMaterielId(id));
    }
    @Operation(summary = "delete by achatMateriel id")
    @DeleteMapping("achatMateriel/id/{id}")
    public int deleteByAchatMaterielId(@PathVariable Long id){
        return service.deleteByAchatMaterielId(id);
    }

    @Operation(summary = "Finds a achatMaterielDetail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AchatMaterielDetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds achatMaterielDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AchatMaterielDetailDto>> findByCriteria(@RequestBody AchatMaterielDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated achatMaterielDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AchatMaterielDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports achatMaterielDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AchatMaterielDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets achatMaterielDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AchatMaterielDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public AchatMaterielDetailRestAdmin (AchatMaterielDetailAdminService service, AchatMaterielDetailConverter converter) {
        super(service, converter);
    }




}
