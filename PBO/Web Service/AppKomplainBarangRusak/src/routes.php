<?php

use Slim\App;
use Slim\Http\Request;
use Slim\Http\Response;

return function (App $app) {
    $container = $app->getContainer();

    $app->get('/[{name}]', function (Request $request, Response $response, array $args) use ($container) {
        // Sample log message
        $container->get('logger')->info("Slim-Skeleton '/' route");

        // Render index view
        return $container->get('renderer')->render($response, 'index.phtml', $args);
    });

    $app->get("/komplain/", function (Request $request, Response $response){
        $sql = "SELECT * FROM komplain";
        $stmt = $this->db->prepare($sql);
        $stmt->execute();
        $result = $stmt->fetchAll();
        return $response->withJson(["status" => "success", "data" => $result], 200);
    });

    $app->post("/keluhan/create/", function(Request $request, Response $response){
        $data = $request->getParsedBody();
        $id_pengguna = $data['id_pengguna'];
        $nama_lengkap = $data['nama_lengkap'];
        $nama_toko = $data['nama_toko'];
        $nama_barang = $data['nama_barang'];
        $tipe_barang = $data['tipe_barang'];
        $tgl_order = $data['tgl_order'];
        $keluhan = $data['keluhan'];
        $sql = "INSERT INTO komplain values(:id_pengguna, :nama_lengkap, :nama_toko, :nama_barang, :tipe_barang, :tgl_order, :keluhan)";
        $stmt = $this->db->prepare($sql);
        $stmt->bindParam("id_pengguna", $id_pengguna);
        $stmt->bindParam("nama_lengkap", $nama_lengkap);
        $stmt->bindParam("nama_toko", $nama_toko);
        $stmt->bindParam("nama_barang", $nama_barang);
        $stmt->bindParam("tipe_barang", $tipe_barang);
        $stmt->bindParam("tgl_order", $tgl_order);
        $stmt->bindParam("keluhan", $keluhan);
        $result = $stmt->execute();
        if(sizeof($result)==0){//apabila data peserta tidak ditemukan
            return $response->withJson(["status" => "error", "message" => "Data tidak berhasil dimasukkan"], 200);
        }
        else {
            return $response->withJson(["status" => "success", "data" => "Data berhasil dimasukkan"], 200);
        }
    });

        $app->post("/keluhan/create/", function(Request $request, Response $response){
        $data = $request->getParsedBody();
        $id_pengguna = $data['id_pengguna'];
        $nama_lengkap = $data['nama_lengkap'];
        $nama_toko = $data['nama_toko'];
        $nama_barang = $data['nama_barang'];
        $tipe_barang = $data['tipe_barang'];
        $tgl_order = $data['tgl_order'];
        $keluhan = $data['keluhan'];
        $sql = "UPDATE komplain SET (:id_pengguna, :nama_lengkap, :nama_toko, :nama_barang, :tipe_barang, :tgl_order, :keluhan)";
        $stmt = $this->db->prepare($sql);
        $stmt->bindParam("id_pengguna", $id_pengguna);
        $stmt->bindParam("nama_lengkap", $nama_lengkap);
        $stmt->bindParam("nama_toko", $nama_toko);
        $stmt->bindParam("nama_barang", $nama_barang);
        $stmt->bindParam("tipe_barang", $tipe_barang);
        $stmt->bindParam("tgl_order", $tgl_order);
        $stmt->bindParam("keluhan", $keluhan);
        $result = $stmt->execute();
        if(sizeof($result)==0){//apabila data peserta tidak ditemukan
            return $response->withJson(["status" => "error", "message" => "Data tidak berhasil dimasukkan"], 200);
        }
        else {
            return $response->withJson(["status" => "success", "data" => "Data berhasil dimasukkan"], 200);
        }
    });
};
