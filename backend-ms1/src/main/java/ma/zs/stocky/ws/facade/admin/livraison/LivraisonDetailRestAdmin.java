package  ma.zs.stocky.ws.facade.admin.livraison;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.livraison.LivraisonDetail;
import ma.zs.stocky.dao.criteria.core.livraison.LivraisonDetailCriteria;
import ma.zs.stocky.service.facade.admin.livraison.LivraisonDetailAdminService;
import ma.zs.stocky.ws.converter.livraison.LivraisonDetailConverter;
import ma.zs.stocky.ws.dto.livraison.LivraisonDetailDto;
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
@RequestMapping("/api/admin/livraisonDetail/")
public class LivraisonDetailRestAdmin  extends AbstractController<LivraisonDetail, LivraisonDetailDto, LivraisonDetailCriteria, LivraisonDetailAdminService, LivraisonDetailConverter> {



    @Operation(summary = "upload one livraisonDetail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple livraisonDetails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all livraisonDetails")
    @GetMapping("")
    public ResponseEntity<List<LivraisonDetailDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  livraisonDetail")
    @PostMapping("")
    public ResponseEntity<LivraisonDetailDto> save(@RequestBody LivraisonDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  livraisonDetail")
    @PutMapping("")
    public ResponseEntity<LivraisonDetailDto> update(@RequestBody LivraisonDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of livraisonDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<LivraisonDetailDto>> delete(@RequestBody List<LivraisonDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified livraisonDetail")
    @DeleteMapping("")
    public ResponseEntity<LivraisonDetailDto> delete(@RequestBody LivraisonDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified livraisonDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple livraisonDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by magasin id")
    @GetMapping("magasin/id/{id}")
    public List<LivraisonDetailDto> findByMagasinId(@PathVariable Long id){
        return findDtos(service.findByMagasinId(id));
    }
    @Operation(summary = "delete by magasin id")
    @DeleteMapping("magasin/id/{id}")
    public int deleteByMagasinId(@PathVariable Long id){
        return service.deleteByMagasinId(id);
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<LivraisonDetailDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by livraison id")
    @GetMapping("livraison/id/{id}")
    public List<LivraisonDetailDto> findByLivraisonId(@PathVariable Long id){
        return findDtos(service.findByLivraisonId(id));
    }
    @Operation(summary = "delete by livraison id")
    @DeleteMapping("livraison/id/{id}")
    public int deleteByLivraisonId(@PathVariable Long id){
        return service.deleteByLivraisonId(id);
    }

    @Operation(summary = "Finds a livraisonDetail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<LivraisonDetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds livraisonDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<LivraisonDetailDto>> findByCriteria(@RequestBody LivraisonDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated livraisonDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody LivraisonDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports livraisonDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody LivraisonDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets livraisonDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody LivraisonDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public LivraisonDetailRestAdmin (LivraisonDetailAdminService service, LivraisonDetailConverter converter) {
        super(service, converter);
    }




}
