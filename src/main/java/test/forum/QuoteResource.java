package test.forum;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import test.forum.entity.QuoteEntity;
import test.forum.entity.UserEntity;
import test.forum.models.QuoteModel;
import test.forum.repo.QuoteRepo;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quotes")
public class QuoteResource {

    @Autowired
    private QuoteRepo quoteRepo;

    @PostMapping
    public QuoteModel create(@Valid @RequestBody QuoteModel quote) {
        return convertToQuoteModel(quoteRepo.save(convertToQuoteEntity(quote)));
    }

    @PutMapping("/{id}")
    public QuoteModel update(@PathVariable UUID id, @Valid @RequestBody QuoteModel quote) {
        quote.setId(id);
        QuoteEntity quoteEntity = convertToQuoteEntity(quote);
        return convertToQuoteModel(quoteRepo.save(quoteEntity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        quoteRepo.deleteById(id);
    }

    @GetMapping("/{id}")
    public QuoteModel getById(@PathVariable UUID id) {
        return convertToQuoteModel(quoteRepo.getById(id));
    }

    @GetMapping("/toplist")
    public List<QuoteModel> toplist() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("creationDate").descending());
        Page<QuoteEntity> list = quoteRepo.findAll(pageable);
        return list.stream().map(QuoteResource::convertToQuoteModel).collect(Collectors.toList());
    }


    //todo
    private static QuoteEntity convertToQuoteEntity(QuoteModel quoteModel) {
        QuoteEntity quoteEntity = new QuoteEntity();
        BeanUtils.copyProperties(quoteModel, quoteEntity);
        UserEntity userEntity = new UserEntity();
        userEntity.setId(quoteModel.getUserId());
        quoteEntity.setUser(userEntity);
        return quoteEntity;
    }

    //todo
    private static QuoteModel convertToQuoteModel(QuoteEntity quoteEntity) {
        QuoteModel quoteModel = new QuoteModel();
        BeanUtils.copyProperties(quoteEntity, quoteModel);
        quoteModel.setUserId(quoteEntity.getUser().getId());
        return quoteModel;
    }

}
