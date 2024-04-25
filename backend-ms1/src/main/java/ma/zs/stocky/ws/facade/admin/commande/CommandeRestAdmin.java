package  ma.zs.stocky.ws.facade.admin.commande;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.commande.Commande;
import ma.zs.stocky.dao.criteria.core.commande.CommandeCriteria;
import ma.zs.stocky.service.facade.admin.commande.CommandeAdminService;
import ma.zs.stocky.ws.converter.commande.CommandeConverter;
import ma.zs.stocky.ws.dto.commande.CommandeDto;
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
@RequestMapping("/api/admin/commande/")
public class CommandeRestAdmin  extends AbstractController<Commande, CommandeDto, CommandeCriteria, CommandeAdminService, CommandeConverter> {



    @Operation(summary = "upload one commande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple commandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all commandes")
    @GetMapping("")
    public ResponseEntity<List<CommandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all commandes")
    @GetMapping("optimized")
    public ResponseEntity<List<CommandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a commande by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<CommandeDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new Commande(ref));
    }

    @Operation(summary = "Saves the specified  commande")
    @PostMapping("")
    public ResponseEntity<CommandeDto> save(@RequestBody CommandeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  commande")
    @PutMapping("")
    public ResponseEntity<CommandeDto> update(@RequestBody CommandeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of commande")
    @PostMapping("multiple")
    public ResponseEntity<List<CommandeDto>> delete(@RequestBody List<CommandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified commande")
    @DeleteMapping("")
    public ResponseEntity<CommandeDto> delete(@RequestBody CommandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified commande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple commandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by entiteAdmin id")
    @GetMapping("entiteAdmin/id/{id}")
    public List<CommandeDto> findByEntiteAdminId(@PathVariable Long id){
        return findDtos(service.findByEntiteAdminId(id));
    }
    @Operation(summary = "delete by entiteAdmin id")
    @DeleteMapping("entiteAdmin/id/{id}")
    public int deleteByEntiteAdminId(@PathVariable Long id){
        return service.deleteByEntiteAdminId(id);
    }

    @Operation(summary = "Finds a commande and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CommandeDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds commandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CommandeDto>> findByCriteria(@RequestBody CommandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated commandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CommandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports commandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CommandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets commande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CommandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CommandeRestAdmin (CommandeAdminService service, CommandeConverter converter) {
        super(service, converter);
    }




}
