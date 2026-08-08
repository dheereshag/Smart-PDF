import React, { useState } from "react";
import UploadPdf from "./components/UploadPdf";
import ViewText from "./components/ViewText";
import Chat from "./components/Chat";


export default function App() {
const [fileId, setFileId] = useState(null);


return (
<div className="container">
<h1>📄 AI Document Analyzer</h1>
<UploadPdf onUploaded={setFileId} />
{fileId && <ViewText fileId={fileId} />}
{fileId && <Chat fileId={fileId} />}
</div>
);
}