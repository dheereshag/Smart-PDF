import React, { useState } from "react";
import api from "../api";


export default function Chat({ fileId }) {
const [question, setQuestion] = useState("");
const [answer, setAnswer] = useState("");


const ask = async () => {
try {
const res = await api.post("/chat", { fileId, question });
setAnswer(res.data.answer || "No response");
} catch (e) {
setAnswer("Chat API failed (mock backend expected)");
}
};


return (
<div className="card">
<h3>Ask Question</h3>
<input value={question} onChange={(e) => setQuestion(e.target.value)} placeholder="Ask about document" />
<button onClick={ask}>Ask</button>
<p><b>Answer:</b> {answer}</p>
</div>
);
}