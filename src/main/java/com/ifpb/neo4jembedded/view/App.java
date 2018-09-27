package com.ifpb.neo4jembedded.view;

import com.ifpb.neo4jembedded.enumeration.Relacionamentos;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.time.LocalDate;
import java.util.Iterator;

public class App {

    public static void main(String[] args) {

        GraphDatabaseService graph = new GraphDatabaseFactory()
                .newEmbeddedDatabase(new File("graph.db"));

        try(Transaction transaction = graph.beginTx()){

//            Node node = graph.findNode(Label.label("Pessoa"),
//                    "cpf","111.111.111-01");

            //node.setProperty("nome", "João da Silva");
//            if(node!=null){
//                System.out.println(node.getProperty("nome"));
//            }else{
//                System.out.println("Objeto não encontrado!");
//            }

//            node.delete();

//            Node node = graph.createNode(Label.label("Pessoa"));
//            node.setProperty("cpf", "111.111.111-01");
//            node.setProperty("nome", "João");
//            node.setProperty("idade", 20);
//
//            Node node2 = graph.createNode(Label.label("Pessoa"));
//            node2.setProperty("cpf", "222.222.222-02");
//            node2.setProperty("nome", "Maria");
//            node2.setProperty("idade", 21);

//            ResourceIterator<Node> iterator = graph
//                    .findNodes(Label.label("Pessoa"));
//
//            while(iterator.hasNext()){
//                Node node = iterator.next();
//                System.out.println(node.getAllProperties());
//            }

            Node node1 = graph.findNode(Label.label("Pessoa"),
                    "cpf","111.111.111-01");

            Iterable<Relationship> relacionamentos = node1
                    .getRelationships(Relacionamentos.AMIGO, Direction.OUTGOING);

            for(Relationship rel : relacionamentos){
                System.out.println(rel.getEndNode().getProperty("nome"));
            }

        }

        graph.shutdown();

    }

}