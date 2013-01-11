package types;

import java.util.List;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class Saving {

	private final ExpensesDatabase database;

	public Saving(ExpensesDatabase database) {
		this.database = database;
	}

	public void saveFile() {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {

			DocumentBuilder builder = factory.newDocumentBuilder();

			DOMImplementation implementation = builder.getDOMImplementation();

			Document document = implementation.createDocument(null, "xml", null);

			document.setXmlVersion("1.0"); // asignamos la version de nuestro XML

			Element root = document.createElement("Data"); // creamos el elemento raiz

			Element input = document.createElement("Expenditure"); // creamos un nuevo elemento

			List<Transaction> transactions = database.getTransactions(); // Ingresamos la info

			document.getDocumentElement().appendChild(root); // pegamos la raiz al documento

			root.appendChild(input); // pegamos el elemento hijo a la raiz

			for (Transaction transaction : transactions)
				input.appendChild(transformToXml(transaction, document));

			Source source = new DOMSource(document);
			
			Result result = new StreamResult(new java.io.File("resultados.xml")); // nombre del archivo
			
			Result console = new StreamResult(System.out);
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			transformer.transform(source, console);
		}

		catch (Exception e) {
			System.err.println("Error: " + e);
		}
	}

	private Node transformToXml(Transaction transaction, Document document) { //why Node?
		Element node = document.createElement("Transaction");
		node.setAttribute("uuid", transaction.getUuid());
		node.setAttribute("currency", transaction.getAmountCurrency().name());
		node.setAttribute("amount", "" + transaction.getAmountValue());
		node.setAttribute("date", "" + transaction.getDate().getTime());
		node.setAttribute("user", transaction.getUser().name());
		node.setAttribute("type", transaction.getType().name());
		return node;
	}
}
