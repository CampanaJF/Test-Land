package com.inkwell.contentfulservice.controller;

import com.contentful.java.cda.CDAArray;
import com.contentful.java.cda.CDAAsset;
import com.contentful.java.cda.CDAClient;
import com.contentful.java.cda.CDAEntry;
import com.inkwell.contentfulservice.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

import static com.contentful.java.cda.QueryOperation.IsEqualTo;

@Log4j2
@RestController
@RequestMapping("content")
public class ContentDeliveryController {

    CDAClient client = CDAClient.builder()
            .setSpace("k0cxosve63k0")
            .setToken("db6w4ujczuQlnUJpHIMsNIstSWbYpTq6rYmsbJsxMY0")
            .setEnvironment("dev")
            .build();

    @GetMapping("/raw0")
    public ResponseEntity<Map<String, Object>> testing() {
        final CDAArray all =
                client
                        .fetch(CDAEntry.class)
                        .withContentType("product")
                        .where("fields.brand", IsEqualTo, "Cafe Martinez Thumbnail")
                        .all();

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/raw")
    public ResponseEntity<Collection<Product>> raw() {

        Collection<Product> found = client
                .observeAndTransform(Product.class)
                .all()
                .blockingFirst();

        return new ResponseEntity<>(found,HttpStatus.OK);
    }

    @GetMapping("/raw2")
    public ResponseEntity<Product> raw2() {

        Product found = client
                .observeAndTransform(Product.class)
                .where("fields.brand", IsEqualTo ,"Cafe Martinez Thumbnail")
                .limit(1)
                .all()
                .blockingFirst()
                .iterator()
                .next();

        return new ResponseEntity<>(found,HttpStatus.OK);
    }
//
//    @GetMapping("/last")
//    public <T> T raw() {
//
//        return client
//                .observe
//                .where("fields.title", "Detail-martinez")
//                .reverseOrderBy("sys.createdAt")
//                .limit(1)
//                .all()
//                .blockingFirst()
//                .iterator()
//                .next();
//    }

    public <T> T getLegal(String documentName, Class<T> output) {

        return client
                .observeAndTransform(output)
                .where("fields.nombreDocumento", documentName)
                .reverseOrderBy("sys.createdAt")
                .limit(1)
                .all()
                .blockingFirst()
                .iterator()
                .next();

    }

    // great great assets, this returns the url for the pizza
    @GetMapping("/pizza")
    public ResponseEntity<String> pizza(){
        CDAAsset asset = client
                .fetch(CDAAsset.class)
                .one("7AuwmigpCr8GO8UknG8vWN");
        return new ResponseEntity<>(asset.url(), HttpStatus.OK);
    }

}
