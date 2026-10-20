const messages = document.getElementById('messages');
let lastQuestion = '', lastAnswer = '', branchId = 'main';
function addBubble(text, who) { const el = document.createElement('div'); el.className = 'bubble ' + who; el.textContent = text; messages.appendChild(el); messages.scrollTop = messages.scrollHeight; }
async function ask(text) {
  lastQuestion = text; addBubble(text, 'user');
  const wait = document.createElement('div'); wait.className = 'bubble bot'; wait.textContent = 'Thinking…'; messages.appendChild(wait);
  try {
    const r = await fetch('/api/chat', {method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify({message:text,branchId})});
    const data = await r.json(); lastAnswer = data.answer || 'No answer returned.'; wait.textContent = lastAnswer;
  } catch(e) { wait.textContent = 'Could not connect to the Java backend. Make sure the Spring Boot app is running.'; }
}
document.getElementById('chatForm').addEventListener('submit', e => {e.preventDefault(); const input=document.getElementById('message'); const text=input.value.trim(); if(text){input.value='';ask(text);}});
document.querySelectorAll('.chips button').forEach(b=>b.addEventListener('click',()=>ask(b.textContent)));
document.getElementById('newChat').addEventListener('click',()=>{messages.innerHTML='';branchId='main';addBubble('New chat started. What would you like to explore?','bot');});
document.getElementById('newBranch').addEventListener('click',()=>{branchId='branch-'+Date.now();addBubble('A separate branch chat has started. This starter UI marks it as a branch, but persistent linked-chat context still needs database implementation.','bot');});
document.getElementById('codingPrompt').addEventListener('click',()=>{document.getElementById('message').value='Give me a beginner Java coding exercise about arrays, with hints but not the solution first.';document.getElementById('message').focus();});
document.getElementById('feedbackForm').addEventListener('submit',async e=>{e.preventDefault();const payload={rating:document.getElementById('rating').value,comment:document.getElementById('comment').value,question:lastQuestion,answer:lastAnswer};try{const r=await fetch('/api/feedback',{method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(payload)});const d=await r.json();document.getElementById('feedbackStatus').textContent=d.message||'Feedback received.';}catch(e){document.getElementById('feedbackStatus').textContent='Backend unavailable; start the Java app and try again.';}});
